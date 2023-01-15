import { computed, ref } from "vue";
import { defineStore } from "pinia";
import { useToast } from "primevue/usetoast";
import axios from "axios";
import router from "@/router";

export const useUserStore = defineStore("user", () => {
  const toast = useToast();

  const user = ref();

  const getUser = computed(() => user);

  const urls = {
    login: "http://localhost:3000/api/users/login",
  };

  async function loginUser(login) {
    try {
      const response = await axios.post(urls.login, login);
      axios.defaults.headers.common["Authorization"] =
        "Bearer " + response.data.token;
      user.value = response.data;
      await router.push("/");
    } catch (error) {
      console.log(error);
      toast.add({
        severity: "error",
        summary: "Hiba!",
        detail: error,
        life: 3000,
      });
    }
  }

  return { user, getUser, loginUser };
});
