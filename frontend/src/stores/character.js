import { computed, ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import { useToast } from "primevue/usetoast";

export const useCharacterStore = defineStore("character", () => {
  const toast = useToast();

  const characters = ref([]);

  const getCharacters = computed(() => characters.value);

  const urls = {
    characters: "http://localhost:3000/api/characters",
  };

  async function fetchCharacters(userId) {
    try {
      const response = await axios.get(urls.characters + "/" + userId);
      characters.value = response.data;
    } catch (error) {
      toast.add({
        severity: "error",
        summary: "error.",
        detail: error,
        life: 3000,
      });
    }
  }

  return { getCharacters, fetchCharacters };
});
