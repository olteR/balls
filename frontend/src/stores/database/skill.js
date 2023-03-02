import { computed, ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import { useToast } from "primevue/usetoast";

export const useSkillStore = defineStore("skill", () => {
    const toast = useToast();

    const skill = ref();
    const skills = ref([]);

    const getSkill = computed(() => skill.value);
    const getSkills = computed(() => skills.value);

    const urls = {
        skill: (id) => `http://localhost:3000/api/database/skill/${id}`,
        skills: "http://localhost:3000/api/database/skills",
    };

    async function fetchSkill(id) {
        try {
            const response = await axios.get(urls.skill(id));
            skill.value = response.data;
        } catch (error) {
            toast.add({
                severity: "error",
                summary: "error.",
                detail: error,
                life: 3000,
            });
        }
    }

    async function fetchSkills() {
        try {
            const response = await axios.get(urls.skills);
            skills.value = response.data;
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
        getSkill,
        getSkills,
        fetchSkill,
        fetchSkills,
    };
});
