import { createRouter, createWebHistory } from "vue-router";
import { useStateStore } from "@/stores/state";
import { BREADCRUMB } from "@/utils/const";
// GENERAL
import LoginView from "../views/LoginView.vue";
import ProfileView from "../views/ProfileView.vue";
import GodmodeView from "../views/GodmodeView.vue";
import PageNotFound from "@/views/PageNotFound.vue";
// CAMPAIGNS
import CampaignsView from "../views/campaigns/CampaignsView.vue";
import CampaignHub from "@/views/campaigns/CampaignHub.vue";
// CHARACTERS
import CharactersView from "../views/characters/CharactersView.vue";
// DATABASE
import DatabaseView from "../views/database/DatabaseView.vue";
import AncestriesListView from "../views/database/ancestries/AncestriesListView.vue";
import AncestryDetailsView from "@/views/database/ancestries/AncestryDetailsView.vue";
import SourcesListView from "@/views/database/sources/SourcesListView.vue";
import SourceDetailsView from "@/views/database/sources/SourceDetailsView.vue";
import LanguagesListView from "@/views/database/languages/LanguagesListView.vue";
import LanguageDetailsView from "@/views/database/languages/LanguageDetailsView.vue";
import SkillsListView from "@/views/database/skills/SkillsListView.vue";
import SkillDetailsView from "@/views/database/skills/SkillDetailsView.vue";
import TraitsListView from "@/views/database/traits/TraitsListView.vue";
import TraitDetailsView from "@/views/database/traits/TraitDetailsView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // GENERAL
    {
      path: "/login",
      name: "login",
      component: LoginView,
      props: { breadcrumbs: [] },
    },
    {
      path: "/profile",
      name: "profile",
      component: ProfileView,
      props: { breadcrumbs: [{ name: "profile" }] },
    },
    {
      path: "/godmode",
      name: "godmode",
      component: GodmodeView,
      props: { breadcrumbs: [BREADCRUMB.GODMODE] },
    },
    // CAMPAIGNS
    {
      path: "/campaigns",
      name: "campaigns",
      component: CampaignsView,
      props: { breadcrumbs: [BREADCRUMB.CAMPAIGNS] },
    },
    {
      path: "/campaigns/:id?/hub",
      name: "campaign hub",
      component: CampaignHub,
      props: { breadcrumbs: [BREADCRUMB.CAMPAIGNS] },
    },
    // CHARACTERS
    {
      path: "/characters",
      name: "characters",
      component: CharactersView,
      props: { breadcrumbs: [BREADCRUMB.CHARACTERS] },
    },
    // DATABASE
    {
      path: "/database",
      name: "database",
      component: DatabaseView,
      props: { breadcrumbs: [BREADCRUMB.DATABASE] },
    },
    {
      path: "/database/ancestries",
      name: "ancestries",
      component: AncestriesListView,
      props: { breadcrumbs: [BREADCRUMB.DATABASE, BREADCRUMB.ANCESTRIES] },
    },
    {
      path: "/database/ancestry/:id?",
      name: "ancestry",
      component: AncestryDetailsView,
      props: { breadcrumbs: [BREADCRUMB.DATABASE, BREADCRUMB.ANCESTRIES] },
    },
    {
      path: "/database/sources",
      name: "sources",
      component: SourcesListView,
      props: { breadcrumbs: [BREADCRUMB.DATABASE, BREADCRUMB.SOURCES] },
    },
    {
      path: "/database/source/:id?",
      name: "source",
      component: SourceDetailsView,
      props: { breadcrumbs: [BREADCRUMB.DATABASE, BREADCRUMB.SOURCES] },
    },
    {
      path: "/database/languages",
      name: "languages",
      component: LanguagesListView,
      props: { breadcrumbs: [BREADCRUMB.DATABASE, BREADCRUMB.LANGUAGES] },
    },
    {
      path: "/database/language/:id?",
      name: "language",
      component: LanguageDetailsView,
      props: { breadcrumbs: [BREADCRUMB.DATABASE, BREADCRUMB.LANGUAGES] },
    },
    {
      path: "/database/skills",
      name: "skills",
      component: SkillsListView,
      props: { breadcrumbs: [BREADCRUMB.DATABASE, BREADCRUMB.SKILLS] },
    },
    {
      path: "/database/skill/:id?",
      name: "skill",
      component: SkillDetailsView,
      props: { breadcrumbs: [BREADCRUMB.DATABASE, BREADCRUMB.SKILLS] },
    },
    {
      path: "/database/traits",
      name: "traits",
      component: TraitsListView,
      props: { breadcrumbs: [BREADCRUMB.DATABASE, BREADCRUMB.TRAITS] },
    },
    {
      path: "/database/trait/:id?",
      name: "trait",
      component: TraitDetailsView,
      props: { breadcrumbs: [BREADCRUMB.DATABASE, BREADCRUMB.TRAITS] },
    },

    {
      path: "/",
      redirect: () => {
        return "campaigns";
      },
    },
    {
      path: "/:pathMatch(.*)*",
      name: "404",
      component: PageNotFound,
    },
  ],
});
router.beforeEach((to) => {
  const stateStore = useStateStore();
  const breadcrumbs = [].concat(to.matched[0].props.default.breadcrumbs);
  stateStore.setBreadcrumbs(breadcrumbs);
});
export default router;
