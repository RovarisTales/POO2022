import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MarcaComer {
    private Map<String,ComercializadorEnergia> comercializadores;
    private Map<String,Marca> marcas;

    public MarcaComer(){
        this.marcas = new HashMap<>();
        this.comercializadores = new HashMap<>();
    }

    public void setComercializadores(Map<String, ComercializadorEnergia> comercializadores) {
        this.comercializadores = comercializadores;
    }

    public void setMarcas(Map<String, Marca> marcas) {
        this.marcas = marcas;
    }

    public Map<String,Marca> getMarcas() {
        return marcas;
    }

    public Map<String,ComercializadorEnergia> getComercializadores() {
        return comercializadores;
    }

    public void addComer(ComercializadorEnergia comer) {
        this.comercializadores.put(comer.getNome(),comer);
    }

    public void addMarca(Marca m) {
        this.marcas.put(m.getNome(),m);
    }

    public ArrayList<String> getMarcasString(){
        ArrayList<String> marca = new ArrayList<>();
        for(String marc: this.marcas.keySet()){
            marca.add(marc);
        }
        return marca;
    }
}