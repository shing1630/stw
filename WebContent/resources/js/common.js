function handleRequest(xhr, status, args, dialogInput) {
	if (args.validationFailed) {
		return;
	} else if (args.isShow) {
		dialogInput.show();
	} else if (args.isHide) {
		dialogInput.hide();
	}
}

function startLoad() {
	PF('blockUIWidget').block();
}

function endLoad() {

	PF('blockUIWidget').unblock();
}