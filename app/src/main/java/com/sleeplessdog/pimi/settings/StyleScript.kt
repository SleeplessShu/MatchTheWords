package com.sleeplessdog.pimi.settings

data class ScriptToggleState(
    var isScriptVisible: Boolean,
    var isScriptLatin: Boolean = false,
    var nativeButtonText: String = "",
    var latinButtonText: String = "",
)