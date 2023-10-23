import React from 'react';
import {PersonData} from '../types/PersonData';

export const Person = (props: PersonData) => {
  return <>
    <h4>Information for person {props.name}</h4>
    Address: {props.address}<br/>
    Nationality: {props.nationality}<br/>
    Native language: {props.nativeLanguage}<br/>
    Family Information: {props.familyInformation}<br/>
    Birth date: {props.birth.toString()}<br/>
    Passing date: {props.death?.toString() || "Alive"}<br/>

  </>
}
