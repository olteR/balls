import { computed, ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import { useToast } from "primevue/usetoast";

export const useLanguageStore = defineStore("language", () => {
  const toast = useToast();

  const language = ref();
  const languages = ref([]);

  const getLanguage = computed(() => language.value);
  const getLanguages = computed(() => languages.value);

  const urls = {
    language: (id) => `http://localhost:3000/api/database/language/${id}`,
    languages: "http://localhost:3000/api/database/languages",
  };

  async function fetchOne(id) {
    try {
      const response = await axios.get(urls.language(id));
      language.value = response.data;
    } catch (error) {
      toast.add({
        severity: "error",
        summary: "error.",
        detail: error,
        life: 3000,
      });
    }
  }

  async function fetchList() {
    try {
      const response = await axios.get(urls.languages);
      languages.value = response.data;
    } catch (error) {
      toast.add({
        severity: "error",
        summary: "error.",
        detail: error,
        life: 3000,
      });
    }
  }

  return {
    getLanguage,
    getLanguages,
    fetchOne,
    fetchList,
  };
});
