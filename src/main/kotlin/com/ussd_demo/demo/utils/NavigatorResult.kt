package com.ussd_demo.demo.utils

import com.ussd_demo.demo.enum.Levels

class NavigatorResult(
    var success: Boolean,
    var resetMenu: Boolean = false,
    var menuItem: String = "",
    var isBack: Boolean = false,
    var response: String = "",
    var errorMessage: String = "",
    var level: Levels? = null,
    var terminate: Boolean = false
)