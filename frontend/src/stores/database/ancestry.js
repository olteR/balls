import { computed, ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import { useToast } from "primevue/usetoast";

export const useAncestryStore = defineStore("ancestry", () => {
    const toast = useToast();

    const ancestries = ref([]);

    const getAncestries = computed(() => ancestries.value);

    const urls = {
        ancestries: "http://localhost:3000/api/database/ancestries",
    };

    async function fetchAncestries() {
        try {
            const response = await axios.get(urls.ancestries);
            ancestries.value = response.data;
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
        ancestries,
        getAncestries,
        fetchAncestries,
    };
});
