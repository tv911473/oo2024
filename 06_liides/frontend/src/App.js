// import logo from './logo.svg';
import './App.css';
import { useEffect, useRef, useState} from 'react';

function App() {
  const [kogus, setKogus] = useState(0); // HTMLs esinevad muutujad peavad olema useState sees
  const [asjad, setAsjad] = useState([]);
  const nimiRef = useRef();
  const pikkusRef = useRef();
  const laiusRef = useRef();
  const [asjadekogus, setAsjadeKogus] = useState([]);
  const akNimiRef = useRef();
  const akKogusRef = useRef();

  // uef
  useEffect(() => {
    fetch("http://localhost:8080/api/asjad")
      .then(response => response.json())
      .then(json => {
        setKogus(json.length);
        setAsjad(json);
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
    fetch("http://localhost:8080/api/asjad/" + voti, {"method": "DELETE"})
      .then(response => response.json())
      .then(json => {
        setKogus(json.length);
        setAsjad(json);
      })
  }

  function lisa() {
    if (nimiRef.current.value.trim() === "") {
      return;
    }
    const asi = {
      "nimi": nimiRef.current.value,
      "pikkus": pikkusRef.current.value,
      "laius": laiusRef.current.value,

    }
    fetch("http://localhost:8080/api/asjad",
    {
      "method": "POST",
      "body": JSON.stringify(asi),
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json())
      .then(json => {
        setKogus(json.length);
        setAsjad(json);
      })
  }
  function lisaAK() {
    const lisatavAK = {
      "asi": {"nimi": akNimiRef.current.value},
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
      <label>Pikkus</label> <br />
      <input ref={pikkusRef} type="text" /> <br />
      <label>Laius</label> <br />
      <input ref={laiusRef} type="text" /> <br />
      <button onClick={() => lisa()}>Sisesta</button> <br />
      <br />

      {asjad.map(a => <div>{a.nimi} | {a.pikkus} | {a.laius} <button onClick={() => kustuta(a.nimi)}>x</button> </div>)}
      <hr />

      <label>Asja nimi</label> <br />
      <input ref={akNimiRef} type="text" /> <br />
      <label>Kogus</label> <br />
      <input ref={akKogusRef} type="text" /> <br />
      <button onClick={() => lisaAK()}>Sisesta</button> <br />

      {asjadekogus.map(ak => <div>{ak.id} | {ak.asjad?.nimi} | {ak.kogus} | <button onClick={() => kustutaAK(ak.id)}>x</button> </div>)}

    </div>
  );
}

export default App;
