import { defineStore } from "pinia";
import axios from "axios";
import { useToast } from "primevue/usetoast";

export const useImportStore = defineStore("import", () => {
  const toast = useToast();

  const urls = {
    books: "http://localhost:3000/api/import/books",
    languages: "http://localhost:3000/api/import/languages",
  };

  async function importBooks() {
    try {
      const response = await axios.get(urls.books);
      toast.add({
        severity: "success",
        summary: "successfully imported " + response.data.length + " books",
        detail: response.data.map(book => book.name).join(", "),
        life: 3000,
      });
    } catch (error) {
      toast.add({
        severity: "error",
        summary: "error.",
        detail: error,
        life: 3000,
      });
    }
  }

  async function importLanguages() {
    try {
      const response = await axios.get(urls.languages);
      toast.add({
        severity: "success",
        summary: "successfully imported " + response.data.length + " languages",
        detail: response.data.map(lang => lang.name).join(", "),
        life: 3000,
      });
    } catch (error) {
      toast.add({
        severity: "error",
        summary: "error.",
        detail: error,
        life: 3000,
      });
    }
  }

  return { importBooks, importLanguages };
});
