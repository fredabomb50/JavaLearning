;===================================================================
#NoEnv   ; Recommended for performance and compatibility with future AutoHotkey releases.
SetWorkingDir %A_ScriptDir%
SendMode Input
SetTitleMatchMode, 2
DetectHiddenWindows, On

;rerouting windows key to run left alt instead
LWin::LAlt


filePath := "Resources/macros.txt"
file := FileOpen(filePath, "r")
if (!IsObject(file))
{
	MsgBox, FAILED TO FIND "macros.txt". Unable to copy string.
}
else
{
	;success
}


;===================================================================
::gstag::
	FileReadLine, tempString, %filePath%, 1
	Send, %tempString%{Tab}
return


::gdps::
	FileReadLine, tempString, %filePath%, 2
	Send, %tempString%{Tab}
return

;==================================PART NAMES=======================
^Numpad1::
	FileReadLine, tempString, %filePath%, 3
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^Numpad2::
	FileReadLine, tempString, %filePath%, 4
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^Numpad3::
	FileReadLine, tempString, %filePath%, 5
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^Numpad4::
	FileReadLine, tempString, %filePath%, 6
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^Numpad5::
	FileReadLine, tempString, %filePath%, 7
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^Numpad6::
	FileReadLine, tempString, %filePath%, 8
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^Numpad7::
	FileReadLine, tempString, %filePath%, 9
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^Numpad8::
	FileReadLine, tempString, %filePath%, 10
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^Numpad9::
	FileReadLine, tempString, %filePath%, 11
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^Numpad0::
	FileReadLine, tempString, %filePath%, 12
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

;==================================PART NAMES=======================



;==================================PART NUMBERS=======================
^!Numpad1::
	FileReadLine, tempString, %filePath%, 13
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!Numpad2::
	FileReadLine, tempString, %filePath%, 14
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!Numpad3::
	FileReadLine, tempString, %filePath%, 15
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!Numpad4::
	FileReadLine, tempString, %filePath%, 16
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!Numpad5::
	FileReadLine, tempString, %filePath%, 17
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!Numpad6::
	FileReadLine, tempString, %filePath%, 18
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!Numpad7::
	FileReadLine, tempString, %filePath%, 19
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!Numpad8::
	FileReadLine, tempString, %filePath%, 20
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!Numpad9::
	FileReadLine, tempString, %filePath%, 21
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!Numpad0::
	FileReadLine, tempString, %filePath%, 22
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

	;==================================NEW PARTS=======================

^!+Numpad1::
	FileReadLine, tempString, %filePath%, 23
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+Numpad2::
	FileReadLine, tempString, %filePath%, 24
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+Numpad3::
	FileReadLine, tempString, %filePath%, 25
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+Numpad4::
	FileReadLine, tempString, %filePath%, 26
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+Numpad5::
	FileReadLine, tempString, %filePath%, 27
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+Numpad6::
	FileReadLine, tempString, %filePath%, 28
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+Numpad7::
	FileReadLine, tempString, %filePath%, 29
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+Numpad8::
	FileReadLine, tempString, %filePath%, 30
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+Numpad9::
	FileReadLine, tempString, %filePath%, 31
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+Numpad0::
	FileReadLine, tempString, %filePath%, 32
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

;===================================================================
;numpad must be off
^!+NumpadEnd::
	FileReadLine, tempString, %filePath%, 33
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+NumpadIns::
	FileReadLine, tempString, %filePath%, 34
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+NumpadDown::
	FileReadLine, tempString, %filePath%, 35
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+NumpadPgDn::
	FileReadLine, tempString, %filePath%, 36
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+NumpadLeft::
	FileReadLine, tempString, %filePath%, 37
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+NumpadClear::
	FileReadLine, tempString, %filePath%, 38
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+NumpadRight::
	FileReadLine, tempString, %filePath%, 39
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+NumpadHome::
	FileReadLine, tempString, %filePath%, 40
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+NumpadUp::
	FileReadLine, tempString, %filePath%, 41
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return

^!+NumpadPgUp::
	FileReadLine, tempString, %filePath%, 42
	TrayTip , Copied "%tempString%", ..., 2, 0
	Send, %tempString%{Tab}
return
