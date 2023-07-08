package FinalProject;

import java.util.*;

public class Module {
    private String moduleName;
    private List<String> materials;

    public Module(String moduleName) {
        this.moduleName = moduleName;
        this.materials = new ArrayList<>();
    }

    public void addMaterial(String material) {
        materials.add(material);
    }

    public void viewMaterials() {
        System.out.println("Module: " + moduleName);
        for (String material : materials) {
            System.out.println(material);
        }
    }

    public String getModuleName() {
        return moduleName;
    }
}
