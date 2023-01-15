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
    refresh: "http://localhost:3000/api/users/refresh",
  };

  async function loginUser(login) {
    try {
      const response = await axios.post(urls.login, login);
      await handleLoginResponse(response);
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

  async function refreshUser(jwt) {
    try {
      const response = await axios.post(urls.refresh, jwt);
      if (response.data.id == null) {
        toast.add({
          severity: "error",
          summary: "Hiba!",
          detail: "Bejelentkezés lejárt. Lépj be újra.",
          life: 3000,
        });
      } else {
        await handleLoginResponse(response);
      }
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

  async function handleLoginResponse(response) {
    localStorage.setItem("jwt", response.data.token);
    axios.defaults.headers.common["Authorization"] =
      "Bearer " + response.data.token;
    user.value = response.data;
    await router.push("/");
  }

  return { user, getUser, loginUser, refreshUser };
});
