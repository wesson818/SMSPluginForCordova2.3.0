// window.plugins.smsComposer

function SMSComposer() {
  this.resultCallback = null; // Function
}

SMSComposer.ComposeResultType = {
    Cancelled:0,
    Saved:1,
    Sent:2,
    Failed:3,
    NotSent:4
}


SMSComposer.prototype.showSMSComposer = function(body) {
	console.log("****************************AVVIATO");
	var args = {};
	if(body)
		args.body = body;
	
	cordova.exec(null, null, "SMSComposer", "showSMSComposer", [args]);
}

SMSComposer.prototype.showSMSComposerWithCallback = function(callback, body) {
	this.resultCallback = callback;
	this.showSMSComposer.apply(this,[body]);
}

SMSComposer.prototype._didFinishWithResult = function(res) {
	this.resultCallback(res);
}

cordova.addConstructor(function()  {
				console.log("****************************");
				if(!window.plugins)
				{
				window.plugins = {};
				}
				
				// shim to work in 1.5 and 1.6
				if (!window.Cordova) {
				window.Cordova = cordova;
				};
				
				window.plugins.smsComposer = new SMSComposer();
});
