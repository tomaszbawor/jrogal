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

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Test for hero class.
 *
 * @author Tomasz Bawor (bawortomasz@gmail.com)
 * @version $Id$
 * @since 0.0.1
 * @checkstyle MethodBodyComments (500 lines)
 * @checkstyle JavadocMethodCheck (500 lines)
 */
public class HeroTest {

    /**
     * Value for stub of hero statistics.
     */
    private static final int STAT_ATTACK = 10;

    /**
     * Value for stub of hero statistics.
     */
    private static final int STAT_DEFENCE = 20;

    /**
     * Mock for statistics.
     */
    private final Statistics statistics = new Statistics(
        HeroTest.STAT_ATTACK,
        HeroTest.STAT_DEFENCE
    );

    @Test(expected = NullPointerException.class)
    public final void shouldThrowExceptionWhenNullNameProvided() {
        // given
        final String name = null;
        // when
        new Hero(name, this.statistics);
    }

    @Test(expected = NullPointerException.class)
    public final void shouldThrowExceptionWhenNullStatisticsProvided() {
        // given
        final Statistics statistic = null;
        final String name = "Name";
        // when
        new Hero(name, statistic);
    }

    @Test
    public final void shouldBeInitializedWithValidName() {
        // given
        final String name = "ValidName";
        // when
        final Hero hero = new Hero(name, this.statistics);
        // then
        Assertions.assertThat(hero.getName()).isEqualTo(name);
    }

}
