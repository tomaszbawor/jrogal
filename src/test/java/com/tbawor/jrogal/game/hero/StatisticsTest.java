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
 * Test for hero statistics.
 *
 * @author Tomasz Bawor (bawortomasz@gmail.com)
 * @version $Id$
 * @since 0.0.1
 * @checkstyle MethodBodyComments (500 lines)
 * @checkstyle JavadocMethodCheck (500 lines)
 */
public final class StatisticsTest {

    /**
     * Default value of statistic for testing.
     */
    private static final int DEFAULT_VALUE = 0;

    /**
     * Value for tested stat.
     */
    private static final int TESTED_VALUE = 123;

    @Test
    public void shouldBeAbleToCreateStatistic() {
        // when
        final Statistics stats =
            new Statistics(
                StatisticsTest.DEFAULT_VALUE,
                StatisticsTest.DEFAULT_VALUE
            );
        // then
        Assertions.assertThat(stats).isNotNull();
    }

    @Test
    public void shouldPopulateAttackWithCorrectValue() {
        // given
        final int attack = StatisticsTest.TESTED_VALUE;
        // when
        final Statistics stats =
            new Statistics(
                attack,
                StatisticsTest.DEFAULT_VALUE
            );
        // then
        Assertions.assertThat(stats.getAttack()).isEqualTo(attack);
    }

    @Test
    public void shouldPopulateDefenceWithCorrectValue() {
        // given
        final int defence = StatisticsTest.TESTED_VALUE;
        // when
        final Statistics stats =
            new Statistics(
                StatisticsTest.DEFAULT_VALUE,
                defence
            );
        // then
        Assertions.assertThat(stats.getDefence()).isEqualTo(defence);
    }

}
