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
package com.tbawor.jrogal.game.hero;

/**
 * Class representing hero that we will be playing in game.
 * @author Tomasz Bawor (bawortomasz@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public class Hero {

    /**
     * Name of a hero.
     */
    private final String name;

    /**
     * Hero statistics.
     */
    private final Statistics statistics;

    /**
     * Constructor of hero.
     * @param name Name of a hero
     * @param statistics Statistic of a Hero
     */
    public Hero(final String name, final Statistics statistics) {
        this.name = name;
        this.statistics = statistics;
    }

    /**
     * Method for getting hero name.
     * @return Hero getName
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Method for getting hero attack.
     * @return Hero attack value
     */
    public final int attack() {
        return this.statistics.getAttack();
    }

    /**
     * Mehtod for getting hero defence.
     * @return Hero defence value
     */
    public final int defence() {
        return this.statistics.getDefence();
    }

}
