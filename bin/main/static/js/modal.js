/**
 * 
 */
	function openModal(userId) {
		var modalId = "modal_" + userId;
		var modal = document.getElementById(modalId);
		modal.style.display = "flex";

	}

	function closeModal(userId) {
		var modalId = "modal_" + userId;
		var modal = document.getElementById(modalId);
		modal.style.display = "none";
	}