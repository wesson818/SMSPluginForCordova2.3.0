SMSPluginForCordova2.3.0
========================

Android SMSPlugin For Cordova Version 2.3.0. Call Android native message app.

Edit from Daniel Shookowsky's EmailComposer

Setup:

Copy Java files from src folder to the src folder or your project.

In config.xml (under "res/xml"), register the plugin (see also "config.xml")

Add the line in your AndroidManifest.xml if you do not have it. (see also "AndroidManifest.xml"):


Call function like below:

window.plugins.smsComposer.showSMSComposerWithCallback(callback(),"my share message");

For the JavaScript call, first parameter the success callback, then the message body. 
