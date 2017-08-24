/**
 * MIT License
 *
 * Copyright (c) 2017 Tomasz Bawor
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.tbawor.jrogal.ui.board;

import com.tbawor.jrogal.game.map.GameLevel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * Object rendering Map on javafx Canvas.
 * @author Tomasz Bawor (bawortomasz@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public class MapRenderer {

    /**
     * Map width in pixels.
     */
    private static final int MAP_WIDTH = 320;

    /**
     * Map height int pixels.
     */
    private static final int MAP_HEIGHT = 320;

    /**
     * Map tile size in pixels.
     */
    private static final int TILE_SIZE = 32;

    /**
     * Game level to render.
     */
    private final GameLevel level;

    /**
     * Canvas to render on.
     */
    private final Canvas canvas;

    /**
     * Constructor of MapRenderer.
     * @param level Level to render
     * @param canvas Canvas to render on
     */
    MapRenderer(final GameLevel level, final Canvas canvas) {
        this.level = level;
        this.canvas = canvas;
    }

    /**
     * Method rendering map on canvas provided in constructor.
     */
    public final void render() {
        final GraphicsContext context = this.canvas.getGraphicsContext2D();
        for (
            int xpixel = 0;
            xpixel < MapRenderer.MAP_WIDTH;
            xpixel = xpixel + MapRenderer.TILE_SIZE
        ) {
            for (
                int ypixel  = 0;
                ypixel < MapRenderer.MAP_HEIGHT;
                ypixel = ypixel + MapRenderer.TILE_SIZE
            ) {
                context.drawImage(
                    this.level.getTile(
                        xpixel / MapRenderer.TILE_SIZE,
                        ypixel / MapRenderer.TILE_SIZE
                    ).getImage(),
                    xpixel,
                    ypixel
                );
            }
        }
    }

}
