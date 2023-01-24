import { defineStore } from "pinia";
import axios from "axios";
import { useToast } from "primevue/usetoast";

export const useImportStore = defineStore("import", () => {
  const toast = useToast();

  const urls = {
    books: "http://localhost:3000/api/import/books",
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

  return { importBooks };
});
