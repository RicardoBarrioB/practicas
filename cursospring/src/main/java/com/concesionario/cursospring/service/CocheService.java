package com.concesionario.cursospring.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concesionario.cursospring.entity.Coche;
import com.concesionario.cursospring.repository.CocheRepository;

@Service
public class CocheService {
	
	@Autowired
	private CocheRepository cocheRepository;

	public Coche save(Coche coche) {
		if(coche != null)
			return cocheRepository.save(coche);
		return null;
	}

	public List<Coche> listAll() {
		return cocheRepository.findAll();
	}

	public Boolean deleteCoche(Coche coche) {
		if (coche != null) {
			cocheRepository.delete(coche);
			return true;
		}
		return false;
	}

	public Boolean deleteById(Long id) {
		return(deleteCoche(findById(id).orElse(null)));
	}

	public Optional<Coche> findById(Long id){
		return cocheRepository.findById(id);
	}

	public void calcularPegatina(Coche coche){

		String letras = coche.getMatricula().substring(5);

		switch (coche.getCombustible()) {
			case ELECTRICO:
				coche.setPegatina("0");
				break;

			case DIESEL:
				if (letras.compareTo("HVF") > 0)
					coche.setPegatina("C");
				else if (letras.compareTo("DVB") > 0)
					coche.setPegatina("B");
				else
					coche.setPegatina("A");
				break;

			case GASOLINA:
				if (letras.compareTo("DVB") > 0)
					coche.setPegatina("C");
				else if (letras.compareTo("BBB") >= 0)
					coche.setPegatina("B");
				else
					coche.setPegatina("A");
				break;

			default:
				coche.setPegatina("A");
				break;
		}
	}

	private static final Map<String, String> matriculas = new TreeMap<>();

    static {
        try (FileReader reader = new FileReader("matriculas.json")) {
            JSONObject jsonObject = new JSONObject(new JSONTokener(reader));

            for (Iterator<String> claves = jsonObject.keys(); claves.hasNext();) {
                String year = claves.next();
                JSONObject months = jsonObject.getJSONObject(year);

                for (Iterator<String> monthClaves = months.keys(); monthClaves.hasNext();) {
                    String month = monthClaves.next();
                    String key = months.getString(month);
                    String value = month + year;
                    matriculas.put(key, value);
                }
            }

        } catch (FileNotFoundException e) {
        	e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public String findMesYAnio(String matricula) {
        String letrasMatricula = matricula.substring(5);
        if (matriculas.containsKey(letrasMatricula)) {
            return matriculas.get(letrasMatricula);
        } else {
            for (Map.Entry<String, String> entry : matriculas.entrySet()) {
                if (entry.getKey().contains(letrasMatricula)) {
                    return entry.getValue();
                }
            }
        }
        return "Matrícula no encontrada";
    }

}
