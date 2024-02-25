"use client";
import React, { useState } from "react";
import HexGrid from "./components/HexGrid";
import CountTimer from "./components/CountTimer";
import styles from "./game.module.css";
import AceEditor from "react-ace";
import "ace-builds/src-noconflict/mode-java";
import "ace-builds/src-noconflict/theme-dracula";
import "ace-builds/src-noconflict/ext-language_tools";

const App = () => {
  const [planText, setPlanText] = useState("");
  const [errorMgs, setErrorMgs] = useState(null);


  return (
    <div className={styles.appcontainer}>
      {/* Render Countdown Timer */}
      <div className={styles.timerContainer}>
        <CountTimer
          countdownTimestampMs={Date.now() + 7 * 60 * 1000}
          minutes={7}
          seconds={0}
        />
      </div>

      {/* Render Construction Plan */}
      <div className="cst-wrapper">
        <p style={{ fontFamily: "Lover", fontSize: "30px" }}>CONSTRUCTION PLAN</p>
        {/* Render Ace Editor */}
        <AceEditor
          className="my-editor"
          mode="java"
          theme="dracula"
          name="plan-editor"
          editorProps={{ $blockScrolling: true }}
          fontSize="13px"
          setOptions={{
            fontFamily: "Monaco",
            enableBasicAutocompletion: true,
            enableLiveAutocompletion: true,
            enableSnippets: true,
            enableMultiselect: true,
          }}
          onChange={(e) => {
            setPlanText(e);
            setErrorMgs("");
          }}
        />
      </div>
    </div>
  );
};

export default App;
