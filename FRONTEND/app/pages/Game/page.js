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
      <div className={styles.plan}>
        <div className={styles.cstcontainer}>
          <div className={styles.timerContainer}>
            <CountTimer
              countdownTimestampMs={Date.now() + 7 * 60 * 1000}
              minutes={7}
              seconds={0}
            />
          </div>
          <div className={styles.regions}>
            <div className={styles.hexgridcontainer}>
              <HexGrid column={8} row={8} />
            </div>
          </div>
            <div className={styles.cstbudget}>
              <span>BUDGET : 500 DEPOSIT : 400</span>
            </div>
            <div className={styles.cstbudget}>
              <span>ROW : 8  COLUMN: 8</span>
            </div>
        </div>
        <div className={styles.wrappercontainer}>
          {" "}
          <p style={{ fontFamily: "Lover", fontSize: "30px" }}>
            CONSTRUCTION PLAN
          </p>
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
          <div className={styles.buttoncontainer}>
            <button className={styles.checksyntax}>
              <span>REVISE</span>
            </button>
            <button className={styles.complete}>
              <span>CONFIRM</span>
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default App;
