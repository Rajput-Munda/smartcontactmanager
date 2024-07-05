document.addEventListener("DOMContentLoaded", () => {
  console.log("Script loaded");

  let currentTheme = getTheme();

  changeTheme();

  function changeTheme() {
      // Set the initial theme to the web page
      document.querySelector("html").classList.add(currentTheme);

      // Set the listener to change the theme
      const changeThemeBtn = document.querySelector('#theme-change-btn');
      if (changeThemeBtn) {
          // Update the button text initially
          updateButtonText(changeThemeBtn, currentTheme);

          changeThemeBtn.addEventListener("click", (event) => {
              console.log("Change theme button clicked");
              
              const oldTheme = currentTheme;

              if (currentTheme === "dark") {
                  currentTheme = "light";
              } else {
                  currentTheme = "dark";
              }

              // Update the theme in local storage
              setTheme(currentTheme);

              // Remove the old theme class and add the new theme class
              document.querySelector("html").classList.remove(oldTheme);
              document.querySelector("html").classList.add(currentTheme);

              // Update the button text after changing the theme
              updateButtonText(changeThemeBtn, currentTheme);
          });
      } else {
          console.error("Theme change button not found!");
      }
  }

  // Function to update the button text based on the current theme
  function updateButtonText(button, theme) {
      const buttonText = theme === "dark" ? "Light" : "Dark";
      const spanElement = button.querySelector("span");
      if (spanElement) {
          spanElement.textContent = buttonText;
      } else {
          console.error("Span element not found inside the theme change button!");
      }
  }

  // Set theme in local storage
  function setTheme(theme) {
      localStorage.setItem("theme", theme);
  }

  // Get theme from local storage
  function getTheme() {
      let theme = localStorage.getItem("theme");
      return theme ? theme : "light";
  }
});
