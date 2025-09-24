
document.addEventListener("DOMContentLoaded", () => {
    const tabs = document.querySelectorAll(".perfil-tabs .tab");

    tabs.forEach(tab => {
        tab.addEventListener("click", () => {
            tabs.forEach(t => t.classList.remove("active"));
            tab.classList.add("active");
        });
    });
});

