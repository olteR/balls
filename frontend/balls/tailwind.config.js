/* eslint-env node */
const defaultTheme = require("tailwindcss/defaultTheme");

/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/App.vue",
    "./src/views/**/*.vue",
    "./src/components/**/*.vue",
  ],
  theme: {
    extend: {
      fontFamily: {
        sans: ["Ubuntu", ...defaultTheme.fontFamily.serif],
      },
      backgroundOpacity: false,
    },
  },
  plugins: [],
};
