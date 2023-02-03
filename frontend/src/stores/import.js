import { defineStore } from "pinia";
import axios from "axios";
import { useToast } from "primevue/usetoast";

export const useImportStore = defineStore("import", () => {
  const toast = useToast();

  const urls = {
    ancestries: "http://localhost:3000/api/import/ancestries",
    books: "http://localhost:3000/api/import/books",
    languages: "http://localhost:3000/api/import/languages",
    traits: "http://localhost:3000/api/import/traits",
  };

  async function importAncestries() {
    try {
      const response = await axios.get(urls.ancestries);
      toast.add({
        severity: "success",
        summary:
          "successfully imported " + response.data.length + " ancestries",
        detail: response.data.map((ancestry) => ancestry.name).join(", "),
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

  async function importBooks() {
    try {
      const response = await axios.get(urls.books);
      toast.add({
        severity: "success",
        summary: "successfully imported " + response.data.length + " books",
        detail: response.data.map((book) => book.name).join(", "),
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
        detail: response.data.map((lang) => lang.name).join(", "),
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

  async function importTraits() {
    try {
      const response = await axios.get(urls.traits);
      toast.add({
        severity: "success",
        summary: "successfully imported " + response.data.length + " traits",
        detail: response.data.map((trait) => trait.name).join(", "),
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

  return { importAncestries, importBooks, importLanguages, importTraits };
});
