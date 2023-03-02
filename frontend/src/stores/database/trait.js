import { computed, ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import { useToast } from "primevue/usetoast";

export const useTraitStore = defineStore("trait", () => {
  const toast = useToast();

  const trait = ref();
  const traits = ref([]);

  const getTrait = computed(() => trait.value);
  const getTraits = computed(() => traits.value);

  const urls = {
    trait: (id) => `http://localhost:3000/api/database/trait/${id}`,
    traits: "http://localhost:3000/api/database/traits",
  };

  async function fetchOne(id) {
    try {
      const response = await axios.get(urls.trait(id));
      trait.value = response.data;
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
      const response = await axios.get(urls.traits);
      traits.value = response.data;
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
    getTrait,
    getTraits,
    fetchOne,
    fetchList,
  };
});
