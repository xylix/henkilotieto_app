import React, {useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';

import {Person } from './components/Person'
import {AddPerson} from './components/AddPerson';
import {PersonData} from './types/PersonData';

function App() {

  let [persons, setPersons] = useState<PersonData[] | null>(null);
  useEffect(() => {
    /* TODO: get actual data from server once it's online
       TODO: ensure the encoded Java LocalDate is parsed correctly and no time information is lost in conversion
       fetch("https//henkilotiedotui.fi/persons")
      .then(response => response.json())
      .then(data => setPersons(data))
    */
    setPersons([{
        name: "Test Testperson",
        id: "000000-000A",
        address: "Teststreet 1",
        nationality: "Finnish",
        nativeLanguage: "Finnish",
        familyInformation: undefined,
        birth: new Date(2000, 20, 20),
        death: undefined,

    }])
  }, [])
  // TODO: missing functionality: Deleting of persons, editing of persons
  return (
    <div className="App">
      <header className="App-header">
        <h2>Add new person</h2>
            <AddPerson />
        <h2>Person list</h2>
        <p>
            {persons && persons.map((data: PersonData) => <Person {...data} />)}
        </p>

      </header>
    </div>
  );
}

export default App;
