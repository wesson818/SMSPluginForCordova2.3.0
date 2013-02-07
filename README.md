SMSPluginForCordova2.3.0
========================

Android SMSPlugin For Cordova Version 2.3.0. Call Android native message app.

Edit from Daniel Shookowsky's EmailComposer

Setup:

Copy Java files from src folder to the src folder or your project.
In config.xml (under "res/xml"), register the plugin <plugin name="SMSComposer" value="com.companyname.projectname.SMSComposer" /> 
Add the following lines in your AndroidManifest.xml if you do not have it.

<!-- Additional permission for SMSComposer plugin -->
<uses-permission android:name="android.permission.SEND_SMS"/>

Call function like below:
window.plugins.smsComposer.showSMSComposerWithCallback(callback(),"my share message");
For the JavaScript call, first parameter the success callback, then the message body. 
