package se.fluen.kpinyin

import kotlin.test.Test
import kotlin.test.assertEquals

class KPinyinTest {
    @Test
    fun testToPinyin() {
        assertEquals("nǐ hǎo", "ni3 hao3".toPinyin())
        assertEquals("nǐ hǎo", "Ni3 hAo3".toPinyin())
        assertEquals("nǐhǎo", "ni3hao3".toPinyin())
        assertEquals("nihǎo", "nihao3".toPinyin())
        assertEquals("", "".toPinyin())
    }

    @Test
    fun test() {
        val a = "ni3hao3".toPinyin()
        assertEquals("nǐhǎo nǐ", ("$a ni3").toPinyin(true))
    }
}