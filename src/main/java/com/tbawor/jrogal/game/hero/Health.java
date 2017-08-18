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

import java.util.Objects;

/**
 * Hero health representation.
 * @author Tomasz Bawor (bawortomasz@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
class Health {

    /**
     * Maximum health value.
     */
    private final int maximum;

    /**
     * Current health value.
     */
    private final int value;

    /**
     * Constructing Health from Statistics.
     * @param statistics Input statistics for health
     */
    Health(final Statistics statistics) {
        this.maximum = getHealthFromStats(statistics);
        this.value = this.maximum;
    }

    /**
     * Gets maximum health value.
     * @return Maximum health value
     */
    public int getMaximumHealth() {
        return this.maximum;
    }

    /**
     * Gets value of health.
     * @return Current health value
     */
    public int getCurrentValue() {
        return this.value;
    }

    /**
     * Method extracting initial health value from statistics.
     * @param statistics Input statistics
     * @return Health value
     */
    private static int getHealthFromStats(final Statistics statistics) {
        Objects.requireNonNull(statistics);
        return statistics.getDefence() * 2;
    }

}
