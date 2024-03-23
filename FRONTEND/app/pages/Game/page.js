"use client";
import Link from "next/link";
import React, { useState } from "react";
import HexGrid from "../components/HexGrid";
import CountTimer from "../components/CountTimer";
import styles from "./game.module.css";
import AceEditor from "react-ace";
import "ace-builds/src-noconflict/mode-java";
import "ace-builds/src-noconflict/theme-dracula";
import "ace-builds/src-noconflict/ext-language_tools";

const App = () => {
  const [planText, setPlanText] = useState("");
  const [errorMgs, setErrorMgs] = useState(null);

  return (
    <div className={styles.bg}>
      <div className="rpgui-content">
        <div className={styles.counttimerwrapper}>
          <CountTimer
            countdownTimestampMs={Date.now() + 1 * 60 * 1000}
            minutes={1}
            seconds={0}
          />
        </div>
        <div
          className="rpgui-container framed"
          style={{
            width: "850px",
            height: "650px",
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            marginTop: "10px",
            marginLeft: "50px",
          }}
        >
          <HexGrid row={16} column={20} />
        </div>
        <div
          className="rpgui-container framed-golden-2"
          style={{
            width: "550px",
            height: "675px",
            display: "flex",
            flexDirection: "column",
            justifyContent: "space-between", // Align items with space between
            alignItems: "center",
            marginTop: "-15px",
            marginLeft: "950px",
            position: "relative",
          }}
        >
          <p
            style={{
              fontFamily: "hello",
              fontSize: "28px",
              textAlign: "center",
              marginTop: "10px",
              marginBottom: "10px",
            }}
          >
            CONSTRUCTION PLAN
          </p>
          <AceEditor
            className="my-editor"
            mode="java"
            theme="dracula"
            name="plan-editor"
            editorProps={{ $blockScrolling: true }}
            fontSize="15px"
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
          <div style={{ display: "flex", alignItems: "center" }}>
            <Link href="/pages/Mapgame">
              <button
                className="rpgui-button"
                type="button"
                style={{ marginRight: "10px" }}
              >
                <p style={{ fontFamily: "hello" }}>CONFIRM</p>
              </button>
            </Link>
            <button className="rpgui-button" type="button">
              <p style={{ fontFamily: "hello" }}>CHECK SYNTAX</p>
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default App;

//
