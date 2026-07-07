package com.juiceybeans.ubergrowth.client.gui.screens.inventory;

import com.google.common.collect.Lists;
import com.juiceybeans.ubergrowth.Ubergrowth;
import com.juiceybeans.ubergrowth.block.blockentity.TackedNotesBlockEntity;
import com.juiceybeans.ubergrowth.menu.TackedNotesMenu;
import com.juiceybeans.ubergrowth.network.UbergrowthNetworking;
import com.mojang.blaze3d.platform.InputConstants;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.client.GameNarrator;
import net.minecraft.client.StringSplitter;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.font.TextFieldHelper;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.mutable.MutableBoolean;
import org.apache.commons.lang3.mutable.MutableInt;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class TackedNotesScreen extends Screen implements MenuAccess<TackedNotesMenu> {
    public static final ResourceLocation NOTE_LOCATION = Ubergrowth.id("textures/gui/tacked_notes.png");
    private static final int TEXT_WIDTH = 114;
    private static final int IMAGE_WIDTH = 192;
    private static final int IMAGE_HEIGHT = 192;

    private final TackedNotesMenu menu;
    private final TackedNotesBlockEntity notesEntity;
    private boolean isModified;
    private int frameTick;
    private String text = "";
    private final TextFieldHelper pageEdit;
    private long lastClickTime;
    private int lastIndex = -1;
    private Button doneButton;
    @Nullable
    private DisplayCache displayCache;

    public TackedNotesScreen(TackedNotesMenu menu, Inventory inventory, Component title) {
        super(GameNarrator.NO_TITLE);
        this.menu = menu;
        this.displayCache = DisplayCache.EMPTY;
        this.notesEntity = menu.getNotesEntity();
        this.text = this.notesEntity.getText();

        this.pageEdit = new TextFieldHelper(
                this::getCurrentPageText,
                this::setCurrentPageText,
                this::getClipboard,
                this::setClipboard,
                (string) -> string.length() < 1024 && this.font.wordWrapHeight(string, TEXT_WIDTH) <= 128
        );
    }

    @Override
    public TackedNotesMenu getMenu() {
        return this.menu;
    }

    private void setClipboard(String clipboardValue) {
        if (this.minecraft != null) {
            TextFieldHelper.setClipboardContents(this.minecraft, clipboardValue);
        }
    }

    private String getClipboard() {
        return this.minecraft != null ? TextFieldHelper.getClipboardContents(this.minecraft) : "";
    }

    private String getCurrentPageText() {
        return this.text;
    }

    private void setCurrentPageText(String text) {
        this.text = text;
        this.isModified = true;
        this.clearDisplayCache();
    }

    public void tick() {
        super.tick();
        ++this.frameTick;
    }

    @Override
    protected void init() {
        this.clearDisplayCache();

        this.doneButton = this.addRenderableWidget(Button.builder(
                CommonComponents.GUI_DONE,
                (button) -> {
                    this.saveChanges();
                    this.minecraft.setScreen(null);
                }
        ).bounds(this.width / 2 - 50, 196, 100, 20).build());

        this.doneButton.setFocused(false);
        this.setFocused(null);
    }

    private void saveChanges() {
        if (this.isModified) {
            this.notesEntity.setText(this.text);
            FriendlyByteBuf buf = PacketByteBufs.create();
            buf.writeBlockPos(this.notesEntity.getBlockPos());
            buf.writeUtf(this.text, 1024);
            ClientPlayNetworking.send(UbergrowthNetworking.UPDATE_NOTES_PACKET, buf);
            this.isModified = false;
        }
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if ((keyCode == InputConstants.KEY_RETURN || keyCode == InputConstants.KEY_NUMPADENTER) && this.doneButton.isFocused()) {
            this.saveChanges();
            this.minecraft.setScreen(null);
            return true;
        }

        if (super.keyPressed(keyCode, scanCode, modifiers)) {
            return true;
        }

        boolean bl = this.bookKeyPressed(keyCode);
        if (bl) {
            this.clearDisplayCache();
            return true;
        }
        return false;
    }

    @Override
    public boolean charTyped(char codePoint, int modifiers) {
        if (super.charTyped(codePoint, modifiers)) {
            return true;
        }
        if (SharedConstants.isAllowedChatCharacter(codePoint)) {
            this.pageEdit.insertText(Character.toString(codePoint));
            this.clearDisplayCache();
            this.isModified = true;
            this.doneButton.setFocused(false);
            this.setFocused(null);
            return true;
        }
        return false;
    }

    private boolean bookKeyPressed(int keyCode) {
        if (Screen.isSelectAll(keyCode)) {
            this.pageEdit.selectAll();
            return true;
        } else if (Screen.isCopy(keyCode)) {
            this.pageEdit.copy();
            return true;
        } else if (Screen.isPaste(keyCode)) {
            this.pageEdit.paste();
            return true;
        } else if (Screen.isCut(keyCode)) {
            this.pageEdit.cut();
            return true;
        }

        TextFieldHelper.CursorStep cursorStep = Screen.hasControlDown() ? TextFieldHelper.CursorStep.WORD : TextFieldHelper.CursorStep.CHARACTER;

        return switch (keyCode) {
            case InputConstants.KEY_RETURN, InputConstants.KEY_NUMPADENTER -> {
                this.pageEdit.insertText("\n");
                yield true;
            }
            case InputConstants.KEY_BACKSPACE -> {
                this.pageEdit.removeFromCursor(-1, cursorStep);
                yield true;
            }
            case InputConstants.KEY_DELETE -> {
                this.pageEdit.removeFromCursor(1, cursorStep);
                yield true;
            }
            case InputConstants.KEY_RIGHT -> {
                this.pageEdit.moveBy(1, Screen.hasShiftDown(), cursorStep);
                yield true;
            }
            case InputConstants.KEY_LEFT -> {
                this.pageEdit.moveBy(-1, Screen.hasShiftDown(), cursorStep);
                yield true;
            }
            case InputConstants.KEY_DOWN -> {
                this.keyDown();
                yield true;
            }
            case InputConstants.KEY_UP -> {
                this.keyUp();
                yield true;
            }
            case InputConstants.KEY_HOME -> {
                this.keyHome();
                yield true;
            }
            case InputConstants.KEY_END -> {
                this.keyEnd();
                yield true;
            }
            default -> false;
        };
    }

    private void keyUp() {
        this.changeLine(-1);
    }

    private void keyDown() {
        this.changeLine(1);
    }

    private void changeLine(int yChange) {
        int i = this.pageEdit.getCursorPos();
        int j = this.getDisplayCache().changeLine(i, yChange);
        this.pageEdit.setCursorPos(j, Screen.hasShiftDown());
    }

    private void keyHome() {
        if (Screen.hasControlDown()) {
            this.pageEdit.setCursorToStart(Screen.hasShiftDown());
        } else {
            int i = this.pageEdit.getCursorPos();
            int j = this.getDisplayCache().findLineStart(i);
            this.pageEdit.setCursorPos(j, Screen.hasShiftDown());
        }
    }

    private void keyEnd() {
        if (Screen.hasControlDown()) {
            this.pageEdit.setCursorToEnd(Screen.hasShiftDown());
        } else {
            DisplayCache displayCache = this.getDisplayCache();
            int i = this.pageEdit.getCursorPos();
            int j = displayCache.findLineEnd(i);
            this.pageEdit.setCursorPos(j, Screen.hasShiftDown());
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.setFocused(null);

        this.renderBackground(guiGraphics);
        int i = (this.width - 192) / 2;

        guiGraphics.blit(NOTE_LOCATION, i, 2, 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);

        DisplayCache displayCache = this.getDisplayCache();
        for (LineInfo lineInfo : displayCache.lines) {
            guiGraphics.drawString(this.font, lineInfo.asComponent, lineInfo.x, lineInfo.y, -16777216, false);
        }

        this.renderHighlight(guiGraphics, displayCache.selection);
        this.renderCursor(guiGraphics, displayCache.cursor, displayCache.cursorAtEnd);

        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    private void renderCursor(GuiGraphics guiGraphics, Pos2i cursorPos, boolean isEndOfText) {
        if (this.frameTick / 6 % 2 == 0) {
            cursorPos = this.convertLocalToScreen(cursorPos);
            if (!isEndOfText) {
                guiGraphics.fill(cursorPos.x, cursorPos.y - 1, cursorPos.x + 1, cursorPos.y + 9, -16777216);
            } else {
                guiGraphics.drawString(this.font, "_", cursorPos.x, cursorPos.y, 0, false);
            }
        }
    }

    private void renderHighlight(GuiGraphics guiGraphics, Rect2i[] highlightAreas) {
        for (Rect2i rect2i : highlightAreas) {
            int i = rect2i.getX();
            int j = rect2i.getY();
            int k = i + rect2i.getWidth();
            int l = j + rect2i.getHeight();
            guiGraphics.fill(i, j, k, l, -16776961);
        }
    }

    private Pos2i convertScreenToLocal(Pos2i screenPos) {
        return new Pos2i(screenPos.x - (this.width - 192) / 2 - 36, screenPos.y - 32);
    }

    private Pos2i convertLocalToScreen(Pos2i localScreenPos) {
        return new Pos2i(localScreenPos.x + (this.width - 192) / 2 + 36, localScreenPos.y + 32);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (super.mouseClicked(mouseX, mouseY, button)) {
            return true;
        }

        if (button == 0) {
            long l = Util.getMillis();
            DisplayCache displayCache = this.getDisplayCache();
            int i = displayCache.getIndexAtPosition(this.font, this.convertScreenToLocal(new Pos2i((int)mouseX, (int)mouseY)));
            if (i >= 0) {
                if (i == this.lastIndex && l - this.lastClickTime < 250L) {
                    if (!this.pageEdit.isSelecting()) {
                        this.selectWord(i);
                    } else {
                        this.pageEdit.selectAll();
                    }
                } else {
                    this.pageEdit.setCursorPos(i, Screen.hasShiftDown());
                }
                this.clearDisplayCache();
            }
            this.lastIndex = i;
            this.lastClickTime = l;
            this.doneButton.setFocused(false);
            this.setFocused(null);
        }
        return true;
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (super.mouseDragged(mouseX, mouseY, button, dragX, dragY)) {
            return true;
        }

        if (button == 0) {
            DisplayCache displayCache = this.getDisplayCache();
            int i = displayCache.getIndexAtPosition(this.font, this.convertScreenToLocal(new Pos2i((int)mouseX, (int)mouseY)));
            this.pageEdit.setCursorPos(i, true);
            this.clearDisplayCache();
        }
        return true;
    }

    private void selectWord(int index) {
        String string = this.getCurrentPageText();
        this.pageEdit.setSelectionRange(
                StringSplitter.getWordPosition(string, -1, index, false),
                StringSplitter.getWordPosition(string, 1, index, false)
        );
    }

    private DisplayCache getDisplayCache() {
        if (this.displayCache == null) {
            this.displayCache = this.rebuildDisplayCache();
        }
        return this.displayCache;
    }

    private void clearDisplayCache() {
        this.displayCache = null;
    }

    private DisplayCache rebuildDisplayCache() {
        String string = this.getCurrentPageText();
        if (string.isEmpty()) {
            return DisplayCache.EMPTY;
        }

        int i = this.pageEdit.getCursorPos();
        int j = this.pageEdit.getSelectionPos();
        IntList intList = new IntArrayList();
        List<LineInfo> list = Lists.newArrayList();
        MutableInt mutableInt = new MutableInt();
        MutableBoolean mutableBoolean = new MutableBoolean();
        StringSplitter stringSplitter = this.font.getSplitter();

        stringSplitter.splitLines(string, TEXT_WIDTH, Style.EMPTY, true, (style, ix, jx) -> {
            int k = mutableInt.getAndIncrement();
            String string2 = string.substring(ix, jx);
            mutableBoolean.setValue(string2.endsWith("\n"));
            String string3 = StringUtils.stripEnd(string2, " \n");
            int l = k * 9;
            Pos2i pos2i = this.convertLocalToScreen(new Pos2i(0, l));
            intList.add(ix);
            list.add(new LineInfo(style, string3, pos2i.x, pos2i.y));
        });

        int[] is = intList.toIntArray();
        boolean bl = i == string.length();
        Pos2i pos2i;
        if (bl && mutableBoolean.isTrue()) {
            pos2i = new Pos2i(0, list.size() * 9);
        } else {
            int k = findLineFromPos(is, i);
            int l = this.font.width(string.substring(is[k], i));
            pos2i = new Pos2i(l, k * 9);
        }

        List<Rect2i> list2 = Lists.newArrayList();
        if (i != j) {
            int l = Math.min(i, j);
            int m = Math.max(i, j);
            int n = findLineFromPos(is, l);
            int o = findLineFromPos(is, m);
            if (n == o) {
                int p = n * 9;
                int q = is[n];
                list2.add(this.createPartialLineSelection(string, stringSplitter, l, m, p, q));
            } else {
                int p = n + 1 > is.length ? string.length() : is[n + 1];
                list2.add(this.createPartialLineSelection(string, stringSplitter, l, p, n * 9, is[n]));
                for (int q = n + 1; q < o; ++q) {
                    int r = q * 9;
                    String string2 = string.substring(is[q], is[q + 1]);
                    int s = (int)stringSplitter.stringWidth(string2);
                    list2.add(this.createSelection(new Pos2i(0, r), new Pos2i(s, r + 9)));
                }
                list2.add(this.createPartialLineSelection(string, stringSplitter, is[o], m, o * 9, is[o]));
            }
        }

        return new DisplayCache(string, pos2i, bl, is, list.toArray(new LineInfo[0]), list2.toArray(new Rect2i[0]));
    }

    static int findLineFromPos(int[] lineStarts, int find) {
        int i = Arrays.binarySearch(lineStarts, find);
        return i < 0 ? -(i + 2) : i;
    }

    private Rect2i createPartialLineSelection(String input, StringSplitter splitter, int startPos, int endPos, int y, int lineStart) {
        String string = input.substring(lineStart, startPos);
        String string2 = input.substring(lineStart, endPos);
        Pos2i pos2i = new Pos2i((int)splitter.stringWidth(string), y);
        Pos2i pos2i2 = new Pos2i((int)splitter.stringWidth(string2), y + 9);
        return this.createSelection(pos2i, pos2i2);
    }

    private Rect2i createSelection(Pos2i corner1, Pos2i corner2) {
        Pos2i pos2i = this.convertLocalToScreen(corner1);
        Pos2i pos2i2 = this.convertLocalToScreen(corner2);
        int i = Math.min(pos2i.x, pos2i2.x);
        int j = Math.max(pos2i.x, pos2i2.x);
        int k = Math.min(pos2i.y, pos2i2.y);
        int l = Math.max(pos2i.y, pos2i2.y);
        return new Rect2i(i, k, j - i, l - k);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void onClose() {
        this.saveChanges();
        super.onClose();
    }

    static class Pos2i {
        public final int x;
        public final int y;

        Pos2i(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class LineInfo {
        final Style style;
        final String contents;
        final Component asComponent;
        final int x;
        final int y;

        public LineInfo(Style style, String contents, int x, int y) {
            this.style = style;
            this.contents = contents;
            this.x = x;
            this.y = y;
            this.asComponent = Component.literal(contents).setStyle(style);
        }
    }

    static class DisplayCache {
        static final DisplayCache EMPTY = new DisplayCache("", new Pos2i(0, 0), true, new int[]{0}, new LineInfo[]{new LineInfo(Style.EMPTY, "", 0, 0)}, new Rect2i[0]);
        private final String fullText;
        final Pos2i cursor;
        final boolean cursorAtEnd;
        private final int[] lineStarts;
        final LineInfo[] lines;
        final Rect2i[] selection;

        public DisplayCache(String fullText, Pos2i cursor, boolean cursorAtEnd, int[] lineStarts, LineInfo[] lines, Rect2i[] selection) {
            this.fullText = fullText;
            this.cursor = cursor;
            this.cursorAtEnd = cursorAtEnd;
            this.lineStarts = lineStarts;
            this.lines = lines;
            this.selection = selection;
        }

        public int getIndexAtPosition(Font font, Pos2i cursorPosition) {
            int i = cursorPosition.y / 9;
            if (i < 0) {
                return 0;
            } else if (i >= this.lines.length) {
                return this.fullText.length();
            } else {
                LineInfo lineInfo = this.lines[i];
                return this.lineStarts[i] + font.getSplitter().plainIndexAtWidth(lineInfo.contents, cursorPosition.x, lineInfo.style);
            }
        }

        public int changeLine(int xChange, int yChange) {
            int i = TackedNotesScreen.findLineFromPos(this.lineStarts, xChange);
            int j = i + yChange;
            int m;
            if (0 <= j && j < this.lineStarts.length) {
                int k = xChange - this.lineStarts[i];
                int l = this.lines[j].contents.length();
                m = this.lineStarts[j] + Math.min(k, l);
            } else {
                m = xChange;
            }
            return m;
        }

        public int findLineStart(int line) {
            int i = TackedNotesScreen.findLineFromPos(this.lineStarts, line);
            return this.lineStarts[i];
        }

        public int findLineEnd(int line) {
            int i = TackedNotesScreen.findLineFromPos(this.lineStarts, line);
            return this.lineStarts[i] + this.lines[i].contents.length();
        }
    }
}