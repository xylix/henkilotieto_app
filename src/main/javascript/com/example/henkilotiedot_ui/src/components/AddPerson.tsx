import React, { useState } from 'react';
import {PersonFormData} from '../types/PersonData';

interface InputFieldProps {
  label: string
  internalName: string
  handleChange: (event: React.FormEvent<HTMLInputElement>) => void
}

const TextInputField = (props: InputFieldProps) => {
  return <>
    <br/>
    <label>{props.label}
      <input style={{ float: 'right' }}
          type="text"
          name={props.internalName}
          onChange={props.handleChange}
      />

    </label>
  </>
}

const DateInputField = (props: InputFieldProps) => {
  return <>
    <br/>
    <label>{props.label}
      <input style={{ float: 'right' }}
          type="date"
          name={props.internalName}
          onChange={props.handleChange}
      />

    </label>
  </>
}



export const AddPerson = () => {
  const [inputs, setInputs] = useState<PersonFormData | {}>({});
  const [displayError, setDisplayError] = useState<string | null>(null);

  const handleChange = (event: React.FormEvent<HTMLInputElement>) => {
    const name = event.currentTarget.name;
    const value = event.currentTarget.value;
    setInputs(values => ({...values, [name]: value}))
  }

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    // FIXME: check that all fields are filled before sending
    const mustContain = ["name", "address", "nationality", "nativeLanguage", "birth"]
    if (!mustContain.every(field => Object.keys(inputs).includes(field))) {
      setDisplayError("All required fields are not filled.")
      return
    }

    await fetch("http://localhost:3000/persons", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(inputs),
    })
  }

  return (
    <>
      {displayError && <p style={{ color: 'red' }} >{displayError}</p>}
      <form onSubmit={handleSubmit}>
        <TextInputField label="Name" internalName="name" handleChange={handleChange}/>
        <TextInputField label="Personal identification number" internalName="id" handleChange={handleChange}/>
        <TextInputField label="Address" internalName="address" handleChange={handleChange}/>
        <TextInputField label="Nationality" internalName="nationality" handleChange={handleChange}/>
        <TextInputField label="Native language" internalName="nativeLanguage" handleChange={handleChange}/>
        <TextInputField label="Family information" internalName="familyInformation" handleChange={handleChange}/>
        <DateInputField label="Birth date" internalName="birth" handleChange={handleChange}/>
        <DateInputField label="Death date" internalName="death" handleChange={handleChange}/>
        <br/>
        <button type="submit">
            Add
         </button>
      </form>
    </>
  )
}
