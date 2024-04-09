// import logo from './logo.svg';
import './App.css';
import { useEffect, useRef, useState} from 'react';

function App() {
  const [kogus, setKogus] = useState(0); // HTMLs esinevad muutujad peavad olema useState sees
  const [numbrid, setNumbrid] = useState([]);
  const nimiRef = useRef();
  const teineRef = useRef();
  const kolmasRef = useRef();
  const [asjadekogus, setAsjadeKogus] = useState([]);
  const akNimiRef = useRef();
  const akKogusRef = useRef();

  // uef
  useEffect(() => {
    fetch("http://localhost:8080/api/numbrid")
      .then(response => response.json())
      .then(json => {
        setKogus(json.length);
        setNumbrid(json);
      }) // body
  }, []);

  useEffect(() => {
    fetch("http://localhost:8080/asjadekogus")
      .then(response => response.json())
      .then(json => {
        setAsjadeKogus(json);

      }) // body
  }, []);

  function kustuta(voti) {
    fetch("http://localhost:8080/api/numbrid/" + voti, {"method": "DELETE"})
      .then(response => response.json())
      .then(json => {
        setKogus(json.length);
        setNumbrid(json);
      })
  }

  function lisa() {
    if (nimiRef.current.value.trim() === "") {
      return;
    }
    const asi = {
      "nimi": nimiRef.current.value,
      "teine": teineRef.current.value,
      "kolmas": kolmasRef.current.value,

    }
    fetch("http://localhost:8080/api/numbrid",
    {
      "method": "POST",
      "body": JSON.stringify(asi),
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json())
      .then(json => {
        setKogus(json.length);
        setNumbrid(json);
      })
  }
  function lisaAK() {
    const lisatavAK = {
      "number": {"nimi": akNimiRef.current.value},
      "kogus": akKogusRef.current.value
    }
    fetch("http://localhost:8080/asjadekogus",
    {
      "method": "POST",
      "body": JSON.stringify(lisatavAK),
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json())
      .then(json => {
        setAsjadeKogus(json);
      })
  }

  function kustutaAK(primaarvoti) {
    fetch("http://localhost:8080/asjadekogus/" + primaarvoti, {"method": "DELETE"})
      .then(response => response.json())
      .then(json => {
        setAsjadeKogus(json);
      })
  }

  return (
    <div className="App">
      Laos on {kogus} asja
      <br /><br />
      <label>Nimi</label> <br />
      <input ref={nimiRef} type="text" /> <br />
      <label>Teine</label> <br />
      <input ref={teineRef} type="text" /> <br />
      <label>Kolmas</label> <br />
      <input ref={kolmasRef} type="text" /> <br />
      <button onClick={() => lisa()}>Sisesta</button> <br />
      <br />

      {numbrid.map(n => <div>{n.nimi} | {n.teine} | {n.kolmas} <button onClick={() => kustuta(n.nimi)}>x</button> </div>)}
      <hr />

      <label>Asja nimi</label> <br />
      <input ref={akNimiRef} type="text" /> <br />
      <label>Kogus</label> <br />
      <input ref={akKogusRef} type="text" /> <br />
      <button onClick={() => lisaAK()}>Sisesta</button> <br />

      {asjadekogus.map(ak => <div>{ak.id} | {ak.numbrid?.nimi} | {ak.kogus} | <button onClick={() => kustutaAK(ak.id)}>x</button> </div>)}

    </div>
  );
}

export default App;
