import { computed, ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import { useToast } from "primevue/usetoast";

export const useSourceStore = defineStore("source", () => {
  const toast = useToast();

  const source = ref();
  const sources = ref([]);

  const getSource = computed(() => source.value);
  const getSources = computed(() => sources.value);

  const urls = {
    source: (id) => `http://localhost:3000/api/database/source/${id}`,
    sources: "http://localhost:3000/api/database/sources",
  };

  async function fetchOne(id) {
    try {
      const response = await axios.get(urls.source(id));
      source.value = response.data;
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
      const response = await axios.get(urls.sources);
      sources.value = response.data;
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
    getSource,
    getSources,
    fetchOne,
    fetchList,
  };
});
