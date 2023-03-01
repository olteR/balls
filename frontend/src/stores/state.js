import { computed, ref } from "vue";
import { defineStore } from "pinia";
import { useToast } from "primevue/usetoast";
import axios from "axios";
import router from "@/router";
import jwtDecode from "jwt-decode";

export const useStateStore = defineStore("state", () => {
  const toast = useToast();

  const urls = {
    login: "http://localhost:3000/api/users/login",
  };

  const user = ref();
  const jwt = ref(
    localStorage.getItem("balls_jwt") ? localStorage.getItem("balls_jwt") : null
  );
  const breadcrumbs = ref([]);
  const loading = ref(false);

  const getUser = computed(() =>
    user.value
      ? user.value
      : jwt.value
      ? {
          id: jwtDecode(jwt.value).uid,
          name: jwtDecode(jwt.value).sub,
        }
      : null
  );
  const getJwt = computed(() => jwt.value);
  const isLoggedIn = computed(() =>
    jwt.value ? Date.now() < jwtDecode(jwt.value).exp * 1000 : false
  );
  const getBreadcrumbs = computed(() => breadcrumbs.value);
  const getLoading = computed(() => loading.value);

  async function loginUser(login) {
    try {
      const response = await axios.post(urls.login, login);
      await handleLoginResponse(response);
      toast.add({
        severity: "success",
        summary: "success.",
        detail: "successful login.",
        life: 3000,
      });
    } catch (error) {
      toast.add({
        severity: "error",
        summary: "Hiba!",
        detail: error,
        life: 3000,
      });
    }
  }

  function logoutUser() {
    delete axios.defaults.headers.common["Authorization"];
    user.value = null;
    localStorage.removeItem("balls_jwt");
  }

  async function handleLoginResponse(response) {
    localStorage.setItem("balls_jwt", response.data.token);
    axios.defaults.headers.common["Authorization"] =
      "Bearer " + response.data.token;
    user.value = response.data;
    await router.push("/");
  }

  function setBreadcrumbs(items) {
    breadcrumbs.value = items;
  }

  function setLoading(val) {
    loading.value = val;
  }

  return {
    getUser,
    getJwt,
    isLoggedIn,
    getBreadcrumbs,
    getLoading,
    loginUser,
    logoutUser,
    setBreadcrumbs,
    setLoading,
  };
});
