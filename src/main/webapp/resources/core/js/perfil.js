
document.addEventListener("DOMContentLoaded", () => {
    const input = document.getElementById("avatarInput");
    const preview = document.getElementById("avatarPreview");

    if (input) {
        input.addEventListener("change", (event) => {
            const file = event.target.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = (e) => {
                    preview.src = e.target.result;
                };
                reader.readAsDataURL(file);
            }
        });
    }
});
