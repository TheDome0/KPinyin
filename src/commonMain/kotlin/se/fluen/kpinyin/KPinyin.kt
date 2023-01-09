package se.fluen.kpinyin


/**
 * Transliterates handwritten input into Pinyin
 * */
fun String.toPinyin(): String = lowercase().splitToSequence(Regex("(?<=[1234])")).fold("") { r, s ->
    when {
        s.contains("iu") -> r + s.replaceFirst('u', placeToneMarks('u', s.last())).dropLast(1)

        s.contains("ui") -> r + s.replaceFirst('i', placeToneMarks('i', s.last())).dropLast(1)

        s.contains('a') -> r + s.replaceFirst('a', placeToneMarks('a', s.last())).dropLast(1)

        s.contains('o') -> r + s.replaceFirst('o', placeToneMarks('o', s.last())).dropLast(1)

        s.contains('e') -> r + s.replaceFirst('e', placeToneMarks('e', s.last())).dropLast(1)

        s.contains('i') -> r + s.replaceFirst('i', placeToneMarks('i', s.last())).dropLast(1)

        s.contains('u') -> r + s.replaceFirst('u', placeToneMarks('u', s.last())).dropLast(1)

        s.contains('ü') -> r + s.replaceFirst('ü', placeToneMarks('ü', s.last())).dropLast(1)

        else -> r + s
    }
}

private fun placeToneMarks(vowel: Char, tone: Char): Char {
    return when (vowel) {
        'a' -> {
            when (tone) {
                '1' -> 'ā'
                '2' -> 'á'
                '3' -> 'ǎ'
                '4' -> 'à'
                else -> '?'
            }
        }

        'o' -> {
            when (tone) {
                '1' -> 'ō'
                '2' -> 'ó'
                '3' -> 'ǒ'
                '4' -> 'ò'
                else -> '?'
            }
        }

        'e' -> {
            when (tone) {
                '1' -> 'ē'
                '2' -> 'é'
                '3' -> 'ě'
                '4' -> 'è'
                else -> '?'
            }
        }

        'i' -> {
            when (tone) {
                '1' -> 'ī'
                '2' -> 'í'
                '3' -> 'ǐ'
                '4' -> 'ì'
                else -> '?'
            }
        }

        'u' -> {
            when (tone) {
                '1' -> 'ū'
                '2' -> 'ú'
                '3' -> 'ǔ'
                '4' -> 'ù'
                else -> '?'
            }
        }

        'ü' -> {
            when (tone) {
                '1' -> 'ǖ'
                '2' -> 'ǘ'
                '3' -> 'ǚ'
                '4' -> 'ǜ'
                else -> '?'
            }
        }

        else -> '?'
    }
}
