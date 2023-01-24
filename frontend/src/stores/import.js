import { defineStore } from "pinia";
import axios from "axios";
import { useToast } from "primevue/usetoast";

export const useImportStore = defineStore("import", () => {
  const toast = useToast();

  const urls = {
    races: "http://localhost:3000/api/import/races",
  };

  async function importRaces() {
    try {
      const response = await axios.get(urls.races);
      console.log(response);
    } catch (error) {
      toast.add({
        severity: "error",
        summary: "error.",
        detail: error,
        life: 3000,
      });
    }
  }

  return { importRaces };
});
