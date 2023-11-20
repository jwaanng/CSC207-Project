package FavPetPage.Redirect;

public class RDIPData {
    private String viewName;
    public RDIPData(String toBeRedirectedViewName){
        viewName = toBeRedirectedViewName;
    }

    public String getViewName() {
        return viewName;
    }
}
