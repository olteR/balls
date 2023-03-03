import { defineStore } from "pinia";
import axios from "axios";
import { useToast } from "primevue/usetoast";

export const useImportStore = defineStore("import", () => {
  const toast = useToast();

  const urls = {
    actions: "http://localhost:3000/api/import/actions",
    ancestries: "http://localhost:3000/api/import/ancestries",
    sources: "http://localhost:3000/api/import/sources",
    languages: "http://localhost:3000/api/import/languages",
    traits: "http://localhost:3000/api/import/traits",
  };

  const importEntity = {
    ACTIONS: async () => {
      await importGeneric("actions");
    },
    ANCESTRIES: async () => {
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
    },
    LANGUAGES: async () => {
      await importGeneric("languages");
    },
    SOURCES: async () => {
      await importGeneric("sources");
    },
    TRAITS: async () => {
      await importGeneric("traits");
    },
  };

  async function importGeneric(entity) {
    try {
      const response = await axios.get(urls[entity]);
      if (response.data.imported.length) {
        toast.add({
          severity: "success",
          summary: "success",
          detail:
            "successfully imported " +
            response.data.imported.length +
            " " +
            entity,
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
            " " +
            entity,
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

  return { importEntity };
});
