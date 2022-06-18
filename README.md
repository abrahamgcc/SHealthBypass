# SHealthBypass
Avoid Samsung Health restrictions

Since v6.20.1.005 Samsung added a check on SHealth which forces the app to be closed on non-stock ROMs. This check is easy to edit on smali, but edit the apk is a headache due to wrong signatures, login issues, recompilation errors... etc

So, let's make it simple and hook the method to just return 0 and let it think our phone is stock.

This has been only tested on Android R/S, since old apks didn't contain this phone status check.

Just install the apk provided and enable it on Xposed/LSPosed.

If you are LSPosed user, it's important to enable access to Samsung Health once the module is installed, else it won't hook the method aka won't work.
