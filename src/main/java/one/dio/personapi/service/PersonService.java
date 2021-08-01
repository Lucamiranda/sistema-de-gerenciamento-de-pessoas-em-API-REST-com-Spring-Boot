package one.dio.personapi.service;

import one.dio.personapi.dto.request.PersonDTO;
import one.dio.personapi.dto.response.MessageResponseDTO;
import one.dio.personapi.entity.Person;
import one.dio.personapi.mapper.PersonMapper;
import one.dio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

     private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson( PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

//        Person personToSave = Person.builder()
//                .firstName(personDTO.getFirstName())
//                .lastName(personDTO.getLastName())
//                .birthDate(personDTO.getBirthDate())
//                .phones(personDTO.getPhones())
//                .build();

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Pessoa criada com o ID : " + savedPerson.getId())
                .build();
    }
}

