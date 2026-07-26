/* ======================================================
   Library Management System
   script.js
====================================================== */


/* ======================================================
   Delete Confirmation
====================================================== */

function confirmDelete() {

    return confirm("Are you sure you want to delete this book?");

}


/* ======================================================
   Reset Form Confirmation
====================================================== */

function confirmReset() {

    return confirm("Clear all entered information?");

}


/* ======================================================
   Success Message
====================================================== */

function showSuccess(message) {

    alert(message);

}


/* ======================================================
   Auto Focus
====================================================== */

document.addEventListener("DOMContentLoaded", function () {

    const firstInput = document.querySelector("input");

    if (firstInput) {

        firstInput.focus();

    }

});