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
      if (response.data.importedAncestries.length) {
        toast.add({
          severity: "success",
          summary: "success",
          detail:
            "successfully imported " +
            response.data.importedAncestries.length +
            " ancestries",
          life: 3000,
        });
      }
      if (response.data.updatedAncestries.length) {
        toast.add({
          severity: "success",
          summary: "success",
          detail:
            "successfully updated " +
            response.data.updatedAncestries.length +
            " ancestries",
          life: 3000,
        });
      }
      if (response.data.heritages.imported.length) {
        toast.add({
          severity: "success",
          summary: "success",
          detail:
            "successfully imported " +
            response.data.heritages.imported.length +
            " heritages",
          life: 3000,
        });
      }
      if (response.data.heritages.updated.length) {
        toast.add({
          severity: "success",
          summary: "success",
          detail:
            "successfully updated " +
            response.data.heritages.updated.length +
            " heritages",
          life: 3000,
        });
      }
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
      if (response.data.imported.length) {
        toast.add({
          severity: "success",
          summary: "success",
          detail:
            "successfully imported " + response.data.imported.length + " books",
          life: 3000,
        });
      }
      if (response.data.updated.length) {
        toast.add({
          severity: "success",
          summary: "success",
          detail:
            "successfully updated " + response.data.updated.length + " books",
          life: 3000,
        });
      }
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
      if (response.data.imported.length) {
        toast.add({
          severity: "success",
          summary: "success",
          detail:
            "successfully imported " +
            response.data.imported.length +
            " languages",
          life: 3000,
        });
      }
      if (response.data.updated.length) {
        toast.add({
          severity: "success",
          summary: "success",
          detail:
            "successfully updated " +
            response.data.updated.length +
            " languages",
          life: 3000,
        });
      }
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
      if (response.data.imported.length) {
        toast.add({
          severity: "success",
          summary: "success",
          detail:
            "successfully imported " +
            response.data.imported.length +
            " traits",
          life: 3000,
        });
      }
      if (response.data.updated.length) {
        toast.add({
          severity: "success",
          summary: "success",
          detail:
            "successfully updated " + response.data.updated.length + " traits",
          life: 3000,
        });
      }
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
