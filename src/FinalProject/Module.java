package FinalProject;

import java.util.ArrayList;
import java.util.List;

public class Module {
    private String moduleName;
    private List<String> materials;

    public Module(String moduleName) {
        this.moduleName = moduleName;
        this.materials = new ArrayList<>();
    }

    public String getModuleName() {
        return moduleName;
    }

    public void addMaterial(String material) {
        this.materials.add(material);
    }

    public List<String> getMaterials() {
        return materials;
    }
}
